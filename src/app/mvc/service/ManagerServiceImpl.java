package app.mvc.service;

import java.util.List;

import app.mvc.dao.ManagerDAO;
import app.mvc.dao.ManagerDAOImpl;
import app.mvc.dto.ItemDTO;
import app.mvc.dto.MemberDTO;
import app.mvc.dto.OrderDTO;
import app.mvc.exception.SearchWrongException;

public class ManagerServiceImpl implements ManagerService {
	private static ManagerService instance = new ManagerServiceImpl();
	
	private ManagerDAO managerDao = ManagerDAOImpl.getInstance();
	
	private ManagerServiceImpl() {}
	
	public static ManagerService getInstance() {
		return instance;
	}

	@Override
	public List<OrderDTO> selectOrderAll() throws SearchWrongException {
		List<OrderDTO> list = managerDao.selectOrderAll();
		if (list.isEmpty()) {
			throw new SearchWrongException(" 주문내역에 주문 정보가 없습니다.");
		}
		return list;
	}

	@Override
	public int selectTotalSalesByPeriod(int period) throws SearchWrongException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemDTO selectItemAll() throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<itemDTO> selectItemTop3() throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertItem(ItemDTO itemDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItemByItemName(String itemName) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateItemStock(ItemDTO itemDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDTO> selectMemberAll() throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO selectMemberByPhone(String phone) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(MemberDTO memberdto) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMemberByPhone(String phone) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMemberGrade() throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
