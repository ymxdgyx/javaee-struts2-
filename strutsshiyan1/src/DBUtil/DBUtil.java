package DBUtil;

import java.util.Hashtable;
import java.util.Map;



/**
 * ���ݿ����������
 * 
 * @author QST����ʵѵ
 *
 */
public class DBUtil {

	private static DBUtil instance = new DBUtil();

	private Hashtable<String, UserBean> userTable = new Hashtable<String, UserBean>();

	/**
	 * ģ�����ݿ�����
	 */
	private DBUtil() {
		UserBean u1 = new UserBean("zhangs", "123456", "zhangs@itshixun.com");
		UserBean u2 = new UserBean("lisi", "123456", "lisi@itshixun.com");
		UserBean u3 = new UserBean("fengjj", "123456", "fengjj@itshixun.com");
		userTable.put("zhangs", u1);
		userTable.put("lisi", u2);
		userTable.put("fengjj", u3);
	}

	public static DBUtil getInstance() {
		return instance;
	}

	public Map<String, UserBean> getUserTable() {
		return userTable;
	}


	/**
	 * �����û�����ѯ�û�����
	 * 
	 * @param userName
	 * @return
	 */
	public UserBean getUser(String userName) {
		return userTable.get(userName);
	}

	/**
	 * ����û�
	 * 
	 * @param register
	 * @throws DBUtilException
	 */
	public void insert(UserBean register)throws Exception  {
		// �жϴ��û������û��Ƿ��Ѵ���
		if (this.getUser(register.getName()) != null) {
			// ���û����Ѵ��ڣ��׳��Զ������ݿ�����쳣����
				throw new Exception("�û����Ѵ��ڣ�");
		}
		userTable.put(register.getName(), register);
	}
}
