package com.friendsofgroot.app.models;

import com.friendsofgroot.app.util.Shareable;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "movies")
public class Movie extends Bookmark implements Shareable {

	@Id
//	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "MOVIE_SEQUENCE" )
//	@SequenceGenerator(name = "MOVIE_SEQUENCE", sequenceName = "MOVIE_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	private int releaseYear;
	private String cast;
	private String directors;
	private String genre;
	private double imdbRating;
	private String title;

	/**
	 * @return
	 */
	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>Book</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<directors>").append(directors).append("</directors>");
		builder.append("<cast>").append(cast).append("</cast>");
		builder.append("<imdbRating>").append(imdbRating).append("</imdbRating>");
		builder.append("<releaseYear>").append(releaseYear).append("</releaseYear>");
		builder.append("<genre").append(genre).append("</genre>");
		builder.append("</item>");
		return builder.toString();
	}
}
