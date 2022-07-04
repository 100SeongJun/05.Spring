package run;

import entity.User;

public class Run {

	public static void main(String[] args) {
		User user = new User();

		try {
			JPA02CRUD.start();
			JPA02CRUD.insert(user, 9L, "성준", 28);
			System.out.println(JPA02CRUD.select(9L));
			JPA02CRUD.update(9L, "뱀", 11);
			System.out.println(JPA02CRUD.select(9L));
			JPA02CRUD.delete(9L);
			JPA02CRUD.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
