package coneccionConMySQL;

public class myTable {

	int test_id;
	char[] test_val = new char[15];

	public myTable(int test_id, char[] test_val) {
		this.test_id = test_id;
		this.test_val = test_val;
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public char[] getTest_val() {
		return test_val;
	}

	public void setTest_val(char[] test_val) {
		this.test_val = test_val;
	}

}
