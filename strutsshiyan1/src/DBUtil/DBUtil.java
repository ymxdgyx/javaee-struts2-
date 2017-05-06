package DBUtil;

import java.util.Hashtable;
import java.util.Map;



/**
 * 数据库操作工具类
 * 
 * @author QST青软实训
 *
 */
public class DBUtil {

	private static DBUtil instance = new DBUtil();

	private Hashtable<String, UserBean> userTable = new Hashtable<String, UserBean>();

	/**
	 * 模拟数据库数据
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
	 * 根据用户名查询用户对象
	 * 
	 * @param userName
	 * @return
	 */
	public UserBean getUser(String userName) {
		return userTable.get(userName);
	}

	/**
	 * 添加用户
	 * 
	 * @param register
	 * @throws DBUtilException
	 */
	public void insert(UserBean register)throws Exception  {
		// 判断此用户名的用户是否已存在
		if (this.getUser(register.getName()) != null) {
			// 若用户名已存在，抛出自定义数据库操作异常对象
				throw new Exception("用户名已存在！");
		}
		userTable.put(register.getName(), register);
	}
}
