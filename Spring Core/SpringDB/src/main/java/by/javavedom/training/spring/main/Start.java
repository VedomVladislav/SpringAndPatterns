package by.javavedom.training.spring.main;

import by.javavedom.training.spring.dao.impls.SQLiteDAO;
import by.javavedom.training.spring.dao.interfaces.MP3Dao;
import by.javavedom.training.spring.dao.objects.Author;
import by.javavedom.training.spring.dao.objects.MP3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Start {

	public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        MP3Dao sqLiteDAO = (MP3Dao) context.getBean("sqliteDAO");

//		MP3 mp3 = new MP3();
//		mp3.setName("New name");
//		mp3.setAuthor("New author");
//
//		MP3 newMp3 = new MP3();
//		newMp3.setName("the best song");
//		newMp3.setAuthor("Ismail");
//
//		List<MP3> list = new ArrayList<>();
//        list.add(mp3);
//        list.add(newMp3);

//        sqLiteDAO.insert(list);

//      new SQLiteDAO().insertWithJDBC(mp3);

//		System.out.println(sqLiteDAO.insert(mp3));
//		sqLiteDAO.delete(20);
//        sqLiteDAO.delete(newMp3);

//        System.out.println("Count mp3 = " + sqLiteDAO.getMP3Count() + "\n");
//
//		System.out.println("MP3 with id = 19 : " + sqLiteDAO.getMP3ByID(19) + "\n");
//
//        List<MP3> listByAuthor = sqLiteDAO.getMP3ListByAuthor("Justin");
//        System.out.println("ListByAuthorName" + listByAuthor + "\n");
//
//        List<MP3> listByName = sqLiteDAO.getMP3ListByName("Sunrise");
//        System.out.println("ListByName" + listByName + "\n");
//
//		Map<String, Integer> map = sqLiteDAO.getStat();
//		for(Map.Entry<String, Integer> item : map.entrySet()){
//			System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().intValue());
//		}

//		System.out.println(sqLiteDAO.insert(mp3));

//		MP3 firstMP3 = new MP3();
//		firstMP3.setName("Song name");
//		firstMP3.setAuthor("Song author");
//
//		MP3 secondMP3 = new MP3();
//		secondMP3.setName("Song name2");
//		secondMP3.setAuthor("Song author2");
//
//		List<MP3> list = new ArrayList<>();
//
//		list.add(firstMP3);
//		list.add(secondMP3);
//
//		System.out.println(sqLiteDAO.insertList(list));


		//--------------------------------------------------------
/*		Author author = new Author();
		author.setName("authorTest");
		MP3 mp3 = new MP3();
		mp3.setName("mp3Test");
		mp3.setAuthor(author);
		System.out.println(sqLiteDAO.insert(mp3));*/
		//--------------------------------------------------------
		//--------------------------------------------------------
/*		Author firstAuthor = new Author();
		firstAuthor.setName("firstAuthor");
		Author secondAuthor = new Author();
		secondAuthor.setName("secondAuthor");

		MP3 firstMP3 = new MP3();
		firstMP3.setName("firstMP3");
		firstMP3.setAuthor(firstAuthor);
		MP3 secondMP3 = new MP3();
		secondMP3.setName("secondMP3");
		secondMP3.setAuthor(secondMP3);

		List<MP3> listMP3 = new ArrayList<>();
		listMP3.add(firstMP3);
		listMP3.add(secondMP3);

		System.out.println(sqLiteDAO.insertList(listMP3));*/
		//--------------------------------------------------------


		MP3 firstMP3 = new MP3();
		firstMP3.setName("Song N55");

		Author author = new Author();
		author.setName("Justin");

		firstMP3.setAuthor(author);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");

		System.out.println(sqLiteDAO.insertMP3(firstMP3));



		((ConfigurableApplicationContext)context).close();// закрытие контекста вручную

	}

}
