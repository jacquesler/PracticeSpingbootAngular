package eCom.validation;

public class Validate {
	
	private Validate() {}

	private static Clause TRUE_CLAUSE = new Clause(true);
	private static Clause FALSE_CLAUSE = new Clause(false);

	public static Clause when(boolean condition) {
		return condition ? TRUE_CLAUSE : FALSE_CLAUSE;
	}

	public static Clause whenNot(boolean condition) {
		return when(!condition);
	}

	public static Clause whenNull(Object object) {
		return when(object == null);
	}
	
	public static Clause whenNullOrLengthZero(String string) {
		return when(string == null || string.length() == 0);
	}

	public static class Clause {

		private final boolean condition;

		public Clause(boolean condition) {
			this.condition = condition;
		}

		public void throwIllegalState(String message) {
			if (condition) {
				throw new IllegalStateException(message);
			}
		}

		public void throwIllegalArgument(String message) {
			if (condition) {
				throw new IllegalArgumentException(message);
			}
		}
		
		public void throwIllegalBetException(String message){
			if(condition){
				throw new IllegalBasketOperation(message);
			}
		}

	}
}
