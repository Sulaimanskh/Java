package ecomm_generics;

// واجهة عامة تحدد عقد التخزين والاسترجاع لأي نوع معرف K ونوع عنصر T
public interface Repository<K, T> {
    void save(K id, T item);
    T findById(K id);
}