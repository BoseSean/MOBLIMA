package org.gp3.moblima.model;

public class Review implements Model {
	/**
	 * Review of a Movie in the form
	 * of comment
	 * String Type
	 */
	private String comment;
	private int rating;

	/**
	 * Constructor for Review
	 *
	 * @param comment
	 */
	public Review(String comment, int rating) {
		this.comment = comment;
		this.rating = rating;
	}

	public Review() {

	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Check if a review already exists
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Review)) return false;

		Review review = (Review) o;

		if (rating != review.rating) return false;
		return getComment() != null ? getComment().equals(review.getComment()) : review.getComment() == null;
	}

}
