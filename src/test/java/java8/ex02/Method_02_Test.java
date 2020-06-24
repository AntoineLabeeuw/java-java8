package java8.ex02;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

	// tag::IDao[]
	interface IDao {
		List<Person> findAll();

		/**
		 * methode qui permet de retourner le nombre de personnes avec un format de type
		 * [14 persons], [30 persons] etc•
		 * 
		 * @return : String
		 */
		default String format() {
			int nbPersonnes = findAll().size();
			return "[" + nbPersonnes + " persons]";
		}

	}
	// end::IDao[]

	// tag::DaoA[]
	class DaoA implements IDao {

		List<Person> people = Data.buildPersonList(20);

		@Override
		public List<Person> findAll() {
			return people;
		}

		/**
		 * redefinition de format() pour y ajouter le nom de la classe.<br/>
		 * exemple de résultat : "DaoA[14 persons]", "DaoA[30 persons]"
		 *
		 */
		@Override
		public String format() {
			return "DaoA" + IDao.super.format();
		}
	}
	// end::DaoA[]

	@Test
	public void test_daoA_format() throws Exception {

		DaoA daoA = new DaoA();

		// TODO invoquer la méthode format() pour que le test soit passant
		String result = daoA.format();

		"DaoA[20 persons]".equals(result);
	}
}
