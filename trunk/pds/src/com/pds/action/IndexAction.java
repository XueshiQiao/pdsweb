/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pds.core.BaseAction;
import com.pds.model.Criticism;
import com.pds.model.FileUD;
import com.pds.model.HotArticle;
import com.pds.model.Link;
import com.pds.model.News;
import com.pds.service.CriticismService;
import com.pds.service.FileUDService;
import com.pds.service.HotArticleService;
import com.pds.service.LinkService;
import com.pds.service.NewsService;

/**
 * @author qiaoxueshi
 *初始话首先上的全部内容
 */

@Controller
@Scope(value="prototype")
public class IndexAction extends BaseAction {

	private static final long serialVersionUID = 3835850216459886279L;
	
	private List<News> news;  //新闻
	private List<HotArticle> hotArticles; //热门文章
	private List<Criticism> tongbaos; //通报 
	private List<FileUD> files; //文件
	private List<Link> links;//友情链接
	
	@Resource
	private NewsService newsService;
	@Resource
	private HotArticleService  hotArticleService;
	@Resource
	private CriticismService criticismService;
	@Resource
	private FileUDService fileUDService;
	@Resource
	private LinkService  linkService;
	
	public String index(){
		try{
			news = newsService.getTop10();
			hotArticles = hotArticleService.getTop10();
			tongbaos = criticismService.getTop10();
			files = fileUDService.getTop10();
			links = linkService.getTop10();
		}catch(RuntimeException e){
			// TODO DO NOTHING;
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	public List<HotArticle> getHotArticles() {
		return hotArticles;
	}
	public void setHotArticles(List<HotArticle> hotArticles) {
		this.hotArticles = hotArticles;
	}
	public List<Criticism> getTongbaos() {
		return tongbaos;
	}
	public void setTongbaos(List<Criticism> tongbaos) {
		this.tongbaos = tongbaos;
	}
	public List<FileUD> getFiles() {
		return files;
	}
	public void setFiles(List<FileUD> files) {
		this.files = files;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public NewsService getNewsService() {
		return newsService;
	}
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	public HotArticleService getHotArticleService() {
		return hotArticleService;
	}
	public void setHotArticleService(HotArticleService hotArticleService) {
		this.hotArticleService = hotArticleService;
	}
	public CriticismService getCriticismService() {
		return criticismService;
	}
	public void setCriticismService(CriticismService criticismService) {
		this.criticismService = criticismService;
	}
	public FileUDService getFileUDService() {
		return fileUDService;
	}
	public void setFileUDService(FileUDService fileUDService) {
		this.fileUDService = fileUDService;
	}
	public LinkService getLinkService() {
		return linkService;
	}
	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}
	
	

}
