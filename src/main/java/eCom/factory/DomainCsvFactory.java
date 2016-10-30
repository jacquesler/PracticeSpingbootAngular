package eCom.factory;

public interface DomainCsvFactory<T> {

	public T createFromCsvLine(String[] input) throws Exception;
}
