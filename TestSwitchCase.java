public class TestSwitchCase {
	public static void main(String[] args) {
		char grade = 'C';
		
		switch(grade)
		{
		case 'A' :
			System.out.println("优秀");
			break;
		case 'B' :
			System.out.println("良好");
			break;
		case 'C' :
			System.out.println("及格吧");
			break;
		case 'D' :
			System.out.println("不及格");
		    break;
		default:
		    System.out.println("期末成绩等级");
		}
		System.out.println("等级是" + grade);
	}
}