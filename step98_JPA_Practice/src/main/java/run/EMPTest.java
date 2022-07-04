package run;

import java.time.LocalDate;
import java.util.List;

import entity.EMP;

public class EMPTest {
	static JPACreate jpa = JPACreate.getInstance();

	public static void main(String[] args) {

		jpa.tx().begin();
		try {

//			getData(7369);
//			System.out.println(allData());
//			for (EMP emp : allData()) {
//				System.out.println(emp);
//			}
//			System.out.println(insert());
			System.out.println(update());
			jpa.tx().commit();
		} catch (

		Exception e) {
			e.printStackTrace();
			jpa.tx().rollback();
		}

	}

	public static EMP getData(Integer id) {
		return jpa.em().find(EMP.class, id);
	}

	// 리턴타입을 바꿔야함
	public static List<EMP> allData() {
//	public static List<Integer> allData() {
		// 모든 emp 찾기
		List<EMP> allEmp = jpa.em().createQuery("select e.empno from EMP e", EMP.class).getResultList();

		// empno 찾기
//		List<Integer> allEmpno = jpa.em().createQuery("select e.empno from EMP e", Integer.class).getResultList();
		return allEmp;
//		return allEmpno;
	}

	public static EMP delete(Integer empno) {
		EMP emp = jpa.em().find(EMP.class, getData(empno));
		jpa.em().remove(emp);
		return emp;
	}

	public static EMP insert() {
		EMP emp = new EMP();
		emp.setEmpno(1);
		emp.setEname("SeongJun");
		emp.setDeptno(13);
		emp.setJob("SALESMAN");
		emp.setMgr(7369);
		emp.setHiredate(LocalDate.now());
		emp.setSal(1000D);
		emp.setComm(null);
		jpa.em().persist(emp);
		return emp;
	}

	public static EMP update() {
		EMP emp = getData(1);
		emp.setEname("??");
		return emp;

	}

}
