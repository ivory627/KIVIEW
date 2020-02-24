package com.mvc.kiview.model.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class CafePageVo {
   private int curpagenum; // 현제 페이지 
   private int totallistcount; //총 게시글 수
   private int pagepernum=10; // 페이지당 보여질 게시글 수   
   private int totalpagecount; // 총 페이지 수
   
   private int displaypagenum = 10; // 페이지 당 보여질 페이지 수 -> << < 1 2 3 4 5 6 7 > >> 7개
   
   
   private int startpage; // 페이지에 보여질 시작 페이지
   private int endpage;   // 페이지에 보여질 끝 페이지
   
   private int rowStart; //한 페이지당 게시글 개수 start
   private int rowEnd; //한 페이지당 게시글 개수 end 
   
   
   private boolean pagenext;
   private boolean pagepre;
   
   private String searchoption;
   private String keyword;
   private int cafe_menu_no;
   private int cafe_board_no;
   
      
   public CafePageVo() {
      this.curpagenum = 1;
      this.pagepernum = 10;
   }
   
   //현재페이지
   public int getCurpagenum() {
      return curpagenum;
   }
   
   


   public void setCurpagenum(int curpagenum) {
      if(curpagenum<=0) {
         this.curpagenum = 1;
         return;
      }
      this.curpagenum =curpagenum;
   }
   // 페이지당 보여질 게시글 수
   public int getPagepernum() {
      return pagepernum;
   }

   
   public void setPagepernum(int pagepernum) {      
      this.pagepernum = pagepernum;
   }
   
   //총 게시글 수
   public int getTotallistcount() {
      return totallistcount;
   }


   public void setTotallistcount(int totallistcount) {
      this.totallistcount = totallistcount;
   }
   
   // 총 페이지 수
   public int getTotalpagecount() {
      return totalpagecount;
   }

   
   public void setTotalpagecount(int pagepernum,int totallistcount) {
      if(totallistcount % pagepernum == 0) {
         this.totalpagecount = (totallistcount / pagepernum);
      }else {
         this.totalpagecount = (int)((totallistcount / pagepernum)+1);
         }   
      
   }   

   // 페이지 당 보여질 페이지 수 
   public int getDisplaypagenum() {
      
      return displaypagenum;
   }

   public void setDisplaypagenum(int displaypagenum) {
      this.displaypagenum = displaypagenum;
   }



    // 페이지에 보여질 끝 페이지
   public int getEndpage() {
      return endpage;
   }
   
   
   public void setEndpage(int curpagenum, int displaypagenum) {
      System.out.println(Math.ceil(3/displaypagenum));
         this.endpage =  (int)( Math.ceil(curpagenum/displaypagenum)* displaypagenum );   
         
      }
      
      
   
   
   // 페이지에 보여질 시작 페이지
   public int getStartpage() {
      return startpage;
   }


   public void setStartpage(int endpage , int displaypagenum ) {
      
      this.startpage = (endpage-displaypagenum) +1;
   }
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
   public int getCurpagenumStart() {      
      return ((curpagenum - 1) * pagepernum) + 1;
   }
   // 리스트 게시글 시작 번호
   public int getRowStart() {
      rowStart = ((curpagenum - 1) * pagepernum) + 1;
      return rowStart;
   }

   public void setRowStart(int rowStart) {
      this.rowStart = rowStart;
   }
    // 리스트 게시글 끝 번호
   public int getRowEnd() {
      rowEnd = rowStart + pagepernum - 1;
      return rowEnd;
   }

   public void setRowEnd(int rowEnd) {
      this.rowEnd = rowEnd;
   }

   
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
   public boolean isPagenext() {
      return pagenext;
   }

   public void setPagenext(int curpagenum,int totalpagecount) {
      
      if(curpagenum == totalpagecount) {
         this.pagenext = false;
      }else {
         this.pagenext = true;
      }
      
   }

   public boolean isPagepre() {
      return pagepre;
   }

   public void setPagepre(int curpagenum) {
      if(curpagenum == 1) {
         this.pagepre = false;
      }
      this.pagepre = true;
   }   

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
   public int getCafe_board_no() {
      return cafe_board_no;
   }
   
   public void setCafe_board_no(int cafe_board_no) {
      this.cafe_board_no = cafe_board_no;
   }

   

   public String getSearchoption() {
      return searchoption;
   }


   public void setSearchoption(String searchoption) {
      this.searchoption = searchoption;
   }


   public String getKeyword() {
      return keyword;
   }


   public void setKeyword(String keyword) {
      this.keyword = keyword;
   }


   public int getCafe_menu_no() {
      return cafe_menu_no;
   }


   public void setCafe_menu_no(int cafe_menu_no) {
      this.cafe_menu_no = cafe_menu_no;
   }
   
      


   @Override
   public String toString() {
      return "CafePageVo [curpagenum=" + curpagenum + ", totallistcount=" + totallistcount + ", pagepernum="
            + pagepernum + ", totalpagecount=" + totalpagecount + ", displaypagenum=" + displaypagenum
            + ", startpage=" + startpage + ", endpage=" + endpage + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
            + ", pagenext=" + pagenext + ", pagepre=" + pagepre + ", searchoption=" + searchoption + ", keyword="
            + keyword + ", cafe_menu_no=" + cafe_menu_no + ", cafe_board_no=" + cafe_board_no + "]";
   }
   
    
   
      
}