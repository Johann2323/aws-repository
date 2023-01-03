package pe.todotic.demoSpringBootS3.model.vm;


import lombok.Data;

@Data
public class Asset {
	
	private byte[] content;
	private String contentType;
	
	public Asset(byte[] content, String contentType) {
		super();
		this.content = content;
		this.contentType = contentType;
	}
	
}
