package run;

import entity.User;

public class JPA02CRUD {
	static JPA01Create jpa = JPA01Create.getInstance();

	public static void start() {
		jpa.runDB();
	}

	public static void insert(User user, Long id, String name, Integer age) throws Exception {
		user.setId(id);
		user.setAge(age);
		user.setName(name);
		jpa.em.persist(user);
	}

//	public static void insert(EMP emp, Integer id, String name, Integer age) throws Exception {
//		emp.setDeptNo(id);
//		emp.set(age);
//		emp.setName(name);
//		jpa.em.persist(user);
//	}

	public static void update(Long id, String name, Integer age) throws Exception {
		User user = jpa.em.find(User.class, id);
		user.setAge(age);
		user.setName(name);

	}

	public static void delete(Long id) throws Exception {
		User user = jpa.em.find(User.class, id);
		jpa.em.remove(user);

	}

	public static User select(Long id) throws Exception {
		User user = jpa.em.find(User.class, id);
		return user;
	}

	public static void close() {
		jpa.close();
	}
}
