package com.nagarro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * getter and setter of image information.
 * pojo
 * 
 * 
 *
 */
@Entity
@Table(name = "image")
public class Image 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imageId")
	private int imageId;
	
	
	@Column(name = "imageName")
	private String imageName;
	
	@Column(name = "imageData")
	@Lob
    private byte[] imageData;
	
	public Image(String imageName, byte[] imageData, float imageSize, String username) {
		super();
		this.imageName = imageName;
		this.imageData = imageData;
		this.imageSize = imageSize;
		this.username = username;
	}
	
	
	public Image() {
	}


	@Column(name = "imageSize")
	private float imageSize;
	
	@Column(name = "username")
	private String username;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public float getImageSize() {
		return imageSize;
	}

	public void setImageSize(float imageSize) {
		this.imageSize = imageSize;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
