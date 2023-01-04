package com.friendsofgroot.app.models;

import com.friendsofgroot.app.util.Shareable;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter @ToString
@Table(name = "weblinks")

public class Weblink extends Bookmark implements Shareable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
	@Column(name="id")
	private long id;
	private String url;
	private String host;
	@Column(name="htmlpage")
	private String htmlPage;
	@Column(name="downloadstatus")
	private DownloadStatus downloadStatus = DownloadStatus.NOT_ATTEMPTED;

	public enum DownloadStatus {
		NOT_ATTEMPTED,
		SUCCESS,
		FAILED,
		NOT_ELIGIBLE;
	}
	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>WebLink</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<url>").append(url).append("</url>");
		builder.append("<host>").append(host).append("</host>");
		builder.append("</item>");
		return builder.toString();
	}
	@Override
	public boolean isWeb3Link() {
		return true;
	}

	//	public Weblink() {
//
//	}

//
//	public String getUrl() {
//		return url;
//	}
//	public void setUrl(String url) {
//		this.url = url;
//	}
//	public String getHost() {
//		return host;
//	}
//	public void setHost(String host) {
//		this.host = host;
//	}
//public String getHtmlPage() {
//	return htmlPage;
//}
//
//	public void setHtmlPage(String htmlPage) {
//		this.htmlPage = htmlPage;
//	}
//
//	public DownloadStatus getDownloadStatus() {
//		return downloadStatus;
//	}
//
//	public void setDownloadStatus(DownloadStatus downloadStatus) {
//
//		this.downloadStatus = downloadStatus;
//	}
/*  {web3, dapp, crypto} in title
*
 */

//	@Override
//	public String toString() {
//		return "Weblink [url=" + url + ", host=" + host + "]";
//	}




}
