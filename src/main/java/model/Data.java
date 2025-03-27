package model;

public class Data {
	private int id;
	private String fileName;
	private String path;
	private String email;
	
	public Data() {
		
	}
	
	public Data(int id,String fileName,String path, String email) {
		this.setId(id);
		this.setFileName(fileName);
		this.setPath(path);
		this.setEmail(email);
	}
	
	public Data(int id,String fileName,String path) {
		this.setId(id);
		this.setFileName(fileName);
		this.setPath(path);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
