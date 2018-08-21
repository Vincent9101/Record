package com.vincent.design.behavioral_pattern.iterator_pattern;

public class NameRepsitory implements Container {

	private Iterator iterator;
	private String[] names = { "Vincent0", "Vincent1", "Vincent2", "Vincent3" };

	public NameRepsitory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new NameIterator();
	}

	private class NameIterator implements Iterator {

		private int index;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.vincent.design.behavioral_pattern.iterator_pattern.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub

			if (index < names.length)
				return true;
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.vincent.design.behavioral_pattern.iterator_pattern.Iterator#next()
		 */
		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if (this.hasNext())
				return names[index++];
			return null;
		}

	}

}
