package framework.platform.html;

import org.openqa.selenium.NoSuchElementException;

public class ParentNotFoundException extends NoSuchElementException {
	private static final long serialVersionUID = -9113615926728828034L;

	public ParentNotFoundException(String reason) {
		super(reason);
	}

	public ParentNotFoundException(String reason, Throwable cause) {
		super(reason, cause);
	}
}
