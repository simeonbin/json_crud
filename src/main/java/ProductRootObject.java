public class ProductRootObject
{
    private String name;
    private String product_id;
    private String category;
    private boolean quanto;
    private String creationDate;
    private String expirationDate;
    private Terms terms;

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getProductId() { return this.product_id; }
    public void setProductId(String product_id) { this.product_id = product_id; }

    public String getCategory() { return this.category; }
    public void setCategory(String category) { this.category = category; }

    public boolean getQuanto() { return this.quanto; }
    public void setQuanto(boolean quanto) { this.quanto = quanto; }

    public String getCreationDate() { return this.creationDate; }
    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

    public String getExpirationDate() { return this.expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }

    public Terms getTerms() { return this.terms; }
    public void setTerms(Terms terms) { this.terms = terms; }

}

