/**
 * 
 */
package jp.co.shantery.sandbox.exception;

/**
 * 暗号化の失敗を表現する実行時例外です。
 * 
 * @author m2-namiki
 * 
 */
public class CipherException extends RuntimeException {

	private static final long serialVersionUID = 4800954899874027503L;

	public CipherException(String message) {
		super(message);
	}

	public CipherException(Throwable cause) {
		super(cause);
	}

	public CipherException(String message, Throwable cause) {
		super(message, cause);
	}

}
