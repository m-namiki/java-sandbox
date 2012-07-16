/**

 * 
 */
package jp.co.shantery.sandbox.exception;

import java.io.IOException;

/**
 * {@link IOException}をラップする実行時例外です。
 * 
 * @author m-namiki
 * 
 */
public class IORuntimeException extends RuntimeException {

	private static final long serialVersionUID = 518451387347404607L;

	public IORuntimeException(IOException cause) {
		super(cause);
	}

	public IORuntimeException(String message, IOException cause) {
		super(message, cause);
	}
}
