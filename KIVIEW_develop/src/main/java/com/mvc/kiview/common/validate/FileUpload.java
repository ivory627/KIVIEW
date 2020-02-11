package com.mvc.kiview.common.validate;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	private String file_name;
	private MultipartFile file;
	
	
	
	public FileUpload(String file_name, MultipartFile file) {
		super();
		this.file_name = file_name;
		this.file = file;
	}
	
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "CafeFile [file_name=" + file_name + ", file=" + file + "]";
	}
	
	
	
	

}
