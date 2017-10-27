package org.gp3.moblima.model;

public class Review implements Model {
	/**
	 * Review of a Movie in the form
	 * of comment
	 * String Type
	 */
	private String comment;

	/**
	 * Getter
	 *
	 * @return
	 */

	/**
	 * Constructor for Review
	 * @param comment
	 */
	public Review(String comment) {
		this.comment = comment;
	}

	public Review() {

	}

	public String getComment() {
		return comment;
	}


	/**
	 * Setter
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
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

		return getComment().equals(review.getComment());
	}

}
