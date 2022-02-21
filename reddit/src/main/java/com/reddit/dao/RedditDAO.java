package com.reddit.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.derby.impl.sql.execute.ConstraintInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.reddit.entity.RedditUser;

public class RedditDAO implements RedditDAOInterface {

	@Override
	public boolean login(RedditUser r) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ss = sf.openSession();

		Query q = ss.createQuery("from com.reddit.entity.RedditUser r where r.email=:em1 and r.password=:ps");
		q.setParameter("em1", r.getEmail());
		q.setParameter("ps", r.getPass());

		System.out.println(r.getEmail() + " | " + r.getPass());

		List<RedditUser> ll = q.getResultList();

		if (ll.size() > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean signup(RedditUser r) {
		boolean val = false;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		EntityTransaction et = session.getTransaction();

		et.begin();
		session.save(r);
		et.commit();
		val = true;
		return val;
	}

	@Override
	public RedditUser viewDetails(RedditUser r) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ss = sf.openSession();

		Query q = ss.createQuery("from com.reddit.entity.RedditUser r where r.email=:em");
		q.setParameter("em", r.getEmail());

		RedditUser rUser = (RedditUser) q.getSingleResult();

		return rUser;
	}

	@Override
	public List<RedditUser> viewAllDetails() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ss = sf.openSession();

		Query q = ss.createQuery("from com.reddit.entity.RedditUser r");
		List<RedditUser> rUser = (List<RedditUser>) q.getResultList();

		return rUser;
	}

	@Override
	public boolean deleteProfile(RedditUser r) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		EntityTransaction et = session.getTransaction();

		et.begin();

		Query q = session.createQuery("delete from com.reddit.entity.RedditUser r where r.email=:em");
		q.setParameter("em", r.getEmail());

		int i = q.executeUpdate();

		et.commit();

		if (i > 0)
			return true;

		return false;

	}

}
