package dustBoxGame;

import java.io.Serializable;

public class Beans implements Serializable{
	private static final long serialVersionUID = 1L;

	private String Level;
	private String Result;
	private String Tensu;
	private String A;
	private String B;

	public void setLevel(String level) {
		this.Level = level;
	}
	public void setResult(String result) {
		this.Result = result;
	}
	public void setTensu(String tensu) {
		this.Tensu = tensu;
	}
	public void setA(String a) {
		this.A = a;
	}
	public void setB(String b) {
		this.B = b;
	}

	public String getLevel() {
		return Level;
	}
	public String getResult() {
		return Result;
	}
	public String getTensu() {
		return Tensu;
	}
	public String getA() {
		return A;
	}
	public String getB() {
		return B;
	}


}