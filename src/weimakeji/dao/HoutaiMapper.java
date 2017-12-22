package weimakeji.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import weimakeji.pojo.CustSourceTotal;
import weimakeji.pojo.Customer;
import weimakeji.pojo.LinkMan;
import weimakeji.pojo.QueryVo;
import weimakeji.pojo.User;
import weimakeji.pojo.Visit;
import weimakeji.pojo.VisitList;
public interface HoutaiMapper {

	public User login(String username, String password);

	public void updatPassword(@Param("newpass")String newpass, @Param("username")String username);

	public void addCustomer(Customer customer);

	public List<Customer> findCustomer();

	public void delCustomer(Integer id);
   
	public Customer findCustomerById(Integer id);

	public void updateCustomer(Customer customer);

	public List<Customer> customerScreen(@Param("custName") String custName);

	public int findCount();

	public List<Customer> findPage(@Param("begin")int begin, @Param("pageSize")int pageSize);

	public void addLinkMan(LinkMan linkMan);

	public List<QueryVo> findLinkMan();

	public QueryVo findLinkManById(Integer id);

	public void updateLinkMan(QueryVo vo);

	public List<QueryVo> linkManScreen(@Param("lkmName") String lkmName);

	public List<User> findUser();

	public void addVisit(Visit visit);

	public List<VisitList> findVisit();

	public void delVisit(Integer id);

	public VisitList findVisitById(Integer id);

	public void updateVisit(VisitList visitList);

	public List<Customer> selectCustomer(Customer customer);

	public List<QueryVo> selectLinkMan(QueryVo vo);

	public List<VisitList> selectVisit(VisitList visitList);

	public int findCountVip();

	public int findCountNewCustomer();



	public int findCountQianZaiCustomer();

	public int findCountLoseCustomer();



	public List<CustSourceTotal> sourceTotals2();

	public List<User> findAllUser();

	public User findUserById(Integer id);

	public void updateUser(User user);

	public void deleteLinkMan(Integer id);

	public List<Customer> findCustomerByIds(Integer[] cid);

	public List<Customer> findCustomerLimit();

	public List<QueryVo> findLinkManLimit();

	public List<VisitList> findVisitLimit();



	

	

	
	
	
	
	
}
