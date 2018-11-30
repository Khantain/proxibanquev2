package fr.formation.proxi.persistance;

import javax.persistence.EntityManager;

public abstract class AbstractDao<T> implements Dao<T> {
	
	protected EntityManager em;
	
	public AbstractDao() {
		this.em = MySqlConnection.getInstance().getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public T read(Integer id, T entity) {
		return (T) this.em.find(entity.getClass(), id);
	}

	@Override
	public T create(T entity) {
		this.em.getTransaction().begin();
		this.em.persist(entity);
		this.em.getTransaction().commit();
		return entity;
	}
	
	@Override
	public T update(T entity) {
		this.em.getTransaction().begin();
		this.em.merge(entity);
		this.em.getTransaction().commit();
		return entity;
	}
	
	@Override
	public boolean delete(T entity) {
		this.em.getTransaction().begin();
		this.em.remove(entity);
		this.em.getTransaction().commit();
		return true;
	}
}
