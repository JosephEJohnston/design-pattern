package ch4_Factory_Method.idcard;

import ch4_Factory_Method.framework.Factory;
import ch4_Factory_Method.framework.Product;

import java.util.HashMap;
import java.util.Map;

public class IDCardFactory extends Factory {
    private Map<String, Integer> owners = new HashMap<>();
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.put(((IDCard)product).getOwner(), owners.size() + 1);
    }

    public Map<String, Integer> getOwners() {
        return owners;
    }
}
