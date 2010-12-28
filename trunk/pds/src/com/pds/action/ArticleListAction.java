/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;

import org.springframework.context.annotation.Scope;
import com.pds.common.page.Paginable;
import com.pds.core.BaseAction;
import com.pds.core.BaseService;
import com.pds.model.Article;

/**
 * @author qiaoxueshi
 *
 */
@Scope(value="prototype")
public abstract class ArticleListAction<T extends Article> extends BaseAction {
	
	private static final long serialVersionUID = 1030782895338327090L;

	protected static final int DEFAULT_PAGE_SIZE = 10;
	
	private String artType;	//文章类型
	private int artId; 	//请求的文章的id
	private int artPageNo;	//请求的页数
	private Paginable<T> artPageModel;  //页面上的数据
	private T article; 

	/**
	 * 需要传递artPageNo参数
	 * @return
	 */
	public String listArticles(){
		if(artPageNo < 1 ){
			artPageNo = 1; //默认载入第一页
		}
		try{
			artPageModel = getService().findPageByHql(artPageNo,DEFAULT_PAGE_SIZE);
			if(artPageModel == null){
				return "pageNotFound";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "pageNotFound";
		}
		
		return "toListPage";
	}
	
	/**
	 * 需要传递artId参数 
	 * @return
	 */
	public String article(){
		if( artId < 1 ){
			return "pageNotFound";
		}
		try{
			article = getService().findById(artId);
			if(article == null){
				return "pageNotFound";
			}
			article.setVisitedCount(article.getVisitedCount()+1); 	//访问量自增1
			getService().saveOrUpdate(article);
		}catch(Exception e){
			e.printStackTrace();
			return "pageNotFound";
		}
		return "toArticlePage";
	}
	
	public abstract BaseService<T> getService();

	public String getArtType() {
		return artType;
	}

	public void setArtType(String artType) {
		this.artType = artType;
	}

	public int getArtId() {
		return artId;
	}

	public void setArtId(int artId) {
		this.artId = artId;
	}

	public int getArtPageNo() {
		return artPageNo;
	}

	public void setArtPageNo(int artPageNo) {
		this.artPageNo = artPageNo;
	}

	public Paginable<T> getArtPageModel() {
		return artPageModel;
	}

	public void setArtPageModel(Paginable<T> artPageModel) {
		this.artPageModel = artPageModel;
	}

	public T getArticle() {
		return article;
	}

	public void setArticle(T article) {
		this.article = article;
	}

}
