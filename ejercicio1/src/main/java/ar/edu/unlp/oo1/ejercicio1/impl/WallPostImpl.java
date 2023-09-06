package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {
	private String text;
	private int likes;
	private boolean isFeatured;

	public WallPostImpl(String text, int likes, boolean isFeatured) {
		this.isFeatured = isFeatured;
		this.likes = likes;
		this.text = text;
	}

	public WallPostImpl() {
		isFeatured = false;
		likes = 0;
		text = "Undefined post";
	}

	/**
	 * Complete con su implementación
	 */

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de
	 * forma adecuada
	 */

	public String getText() {
		return text;
	}

	public int getLikes() {
		return likes;
	}

	public boolean isFeatured() {
		return isFeatured;
	}

	@Override
	public String toString() {
		return "WallPost {" + "text: " + getText() + ", likes: '" + getLikes() + "'" + ", featured: '" + isFeatured()
				+ "'" + "}";
	}

	@Override
	public void setText(String text) {
		this.text = text;

	}

	@Override
	public void like() {
		likes++;

	}

	@Override
	public void dislike() {
		if (likes > 0) {
			likes--;
		}
	}

	@Override
	public void toggleFeatured() {
		isFeatured = !isFeatured;

	}

}
