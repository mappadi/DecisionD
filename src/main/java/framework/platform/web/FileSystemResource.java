package framework.platform.web;

import framework.platform.utilities.FileAssistant;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

public class FileSystemResource {
	private String pathName = null;
	private String fileName = null;
	private Class<?> cls = null;

	public FileSystemResource() {
	}

	/**
	 * Use this constructor when a data source file can be found in the path specified and contains a user-defined object.
	 *
	 * @param pathName
	 * @param fileName
	 * @param cls
	 */
	public FileSystemResource(String pathName, String fileName, Class<?> cls) {
		super();
		setPathName(pathName);
		setFileName(fileName);
		setCls(cls);
	}

	/**
	 * Use this constructor when a data source file can be found as a resource and contains a user-defined object.
	 *
	 * @param fileName
	 * @param cls
	 */
	public FileSystemResource(String fileName, Class<?> cls) {
		this(null, fileName, cls);
	}

	/**
	 * Use this constructor when a data source file can be found in the path specified and does NOT contain a user-defined
	 * object.
	 *
	 * @param pathName
	 * @param fileName
	 */
	public FileSystemResource(String pathName, String fileName) {
		this(pathName, fileName, null);
	}

	/**
	 * Use this constructor when a data source file can be found as a resource and does NOT contain a user-defined object.
	 *
	 * @param fileName
	 */
	public FileSystemResource(String fileName) {
		this(null, fileName, null);
	}

	public String getPathName() {
		return pathName;
	}

	public final void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getFileName() {
		return fileName;
	}

	public final void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Class<?> getCls() {
		return cls;
	}

	public final void setCls(Class<?> cls) {
		this.cls = cls;
	}

	public InputStream getInputStream() {
		InputStream is = null;

		if (this.pathName == null) {
			is = new BufferedInputStream(FileAssistant.loadFile(this.fileName));
		} else {
			File file = new File(this.pathName + this.fileName);
			is = new BufferedInputStream(FileAssistant.loadFile(file));
		}

		return is;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("FileSystemResource: [ ");
		str.append("pathName = " + this.getPathName() + ", ");
		str.append("fileName = " + this.getFileName() + ", ");
		str.append("class = " + this.getCls() + " ]");
		return str.toString();
	}
}
