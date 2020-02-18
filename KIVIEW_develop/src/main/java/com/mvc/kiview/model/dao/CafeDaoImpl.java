package com.mvc.kiview.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.kiview.model.vo.CafeBoardVo;
import com.mvc.kiview.model.vo.CafeCategoryVo;
import com.mvc.kiview.model.vo.CafeMemberVo;
import com.mvc.kiview.model.vo.CafeMenuVo;
import com.mvc.kiview.model.vo.CafeVo;

@Repository
public class CafeDaoImpl implements CafeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	@Override
	public List<CafeVo> cafe_Ulist(int member_no) {

		List<CafeVo> res = new ArrayList();

		try {

			res = sqlSession.selectList(namespace + "cafe_Ulist", member_no);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cafe_Ulist 오류!");
		}

		return res;
	}

	@Override
	public List<CafeVo> cafe_Alist(String member_id) {
		List<CafeVo> res = new ArrayList();

		try {
			res = sqlSession.selectList(namespace + "cafe_Alist", member_id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cafe_Alist 오류");
		}
		return res;
	}

	@Override
	public CafeMemberVo cafe_regyn(CafeMemberVo regyn) {

		CafeMemberVo res = null;

		try {
			res = sqlSession.selectOne(namespace + "cafe_regyn", regyn);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cafe_regyn 오류");
		}

		return res;
	}

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	@Override //카페 오픈시 cafe 테이블 추가
	public int cafe_insert(CafeVo vo) {

		int res = 0;

		try {

			res = sqlSession.insert(namespace + "cafe_insert", vo);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cafeInsert 오류");
		}

		return res;
	}
	
	@Override //카페 오픈시 운영자를 cafe_member에 추가
	public int cafe_insert2(CafeMemberVo vo) {
		int res = 0;
		
		try {

			res = sqlSession.insert(namespace + "cafe_insert2", vo);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cafeInsert2 오류");
		}

		return res;
	}
	

	@Override
	public CafeVo cafe_selectone(int cafe_no) {

		CafeVo vo = new CafeVo();

		try {

			vo = sqlSession.selectOne(namespace + "cafe_selectone", cafe_no);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cafeselectone 오류");
		}

		return vo;
	}

	@Override
	public int menu_insert(CafeMenuVo vo) {
		int res = 0;

		try {
			res = sqlSession.insert(namespace + "menu_insert", vo);

			System.out.println("시퀀스:" + res);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("menuinsert 오류");
		}

		return res;
	}

	@Override
	public int category_insert(String cat) {
		int res = 0;

		try {
			res = sqlSession.insert(namespace + "category_insert", cat);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("categoryinsert 오류");
		}

		return res;
	}

	@Override
	public int cafe_join(CafeMemberVo vo) {

		int res = 0;

		try {
			res = sqlSession.insert(namespace + "cafejoin", vo);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cafejoin 오류");
		}

		return res;
	}

	@Override
	public List<CafeVo> cafe_search(String keyword) {
		List<CafeVo> res = null;

		try {
			res = sqlSession.selectList(namespace + "cafe_search", keyword);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("cafe_search 오류");
		}
		return res;
	}

	@Override
	public List<CafeMenuVo> menu_list(int cafe_no) {
		List<CafeMenuVo> res = null;
		
		try {
			res = sqlSession.selectList(namespace+"menu_select",cafe_no);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("menu_list 오류");
		} 
		return res;
	}

	@Override
	public CafeMenuVo menu_detail1(int no) {
		CafeMenuVo res = null;
		
		try {
			res = sqlSession.selectOne(namespace+"menu_detail1",no); 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("menu_list 오류");
		} 
		return res;
	}

	@Override
	public List<CafeCategoryVo> menu_detail2(int no) {
		List<CafeCategoryVo> res = null;
		
		try {
			res = sqlSession.selectList(namespace+"menu_detail2",no);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("menu_list 오류");
		} 
		return res;
	}

	@Override
	public CafeMenuVo menu_chk(CafeMenuVo menu) {
		CafeMenuVo res = null;
		
		try {
			res = sqlSession.selectOne(namespace+"menu_chk",menu);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("menu_list 오류");
		}
		
		
		return res;
	}

	@Override
	public List<CafeMemberVo> cafe_member_list(int cafe_no) {
		
		List<CafeMemberVo> res = null;
		
		
		try {
			res = sqlSession.selectList(namespace+"cafe_member_list",cafe_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberlist 오류");
		} 
		
		
		
		
		return res;
	}

	@Override
	public int menu_delete(int cafe_menu_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(namespace+"menu_delete",cafe_menu_no);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("menudelete 오류");
		}
		
		return res;
	}

	@Override
	public int category_delete_all(int cafe_menu_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(namespace+"category_delete_all",cafe_menu_no);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("category_delete_all 오류");
		}
		
		return res;
	}

	

	

}