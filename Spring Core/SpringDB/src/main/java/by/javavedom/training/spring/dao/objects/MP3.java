package by.javavedom.training.spring.dao.objects;

public class MP3 {
	private Integer Id;
	private String name;
	private Author author;

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
