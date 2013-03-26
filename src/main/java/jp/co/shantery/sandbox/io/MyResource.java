package jp.co.shantery.sandbox.io;

public class MyResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("called close()");
	}

	@Override
	public String toString() {
		return "This is MyResource object.";
	}
}
