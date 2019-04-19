package com.proje.queries;

public class ProductQueries {

	/**
	 * @author MetinKalinsaz
	 */

	public static final String findProducts = "SELECT P FROM Product P ";

	public static final String findProductById = "SELECT p FROM Product p WHERE p.productId= :productId ";

	public static final String findProductDetails = "SELECT new com.proje.model.ProductDetails(P.productName,P.unitPrice,P.avaible,B.brandName,C.categoryName) "
			+ "FROM Product P LEFT JOIN P.brand B LEFT JOIN P.category C ";

	public static final String findProductDetailsById = "SELECT new com.proje.model.ProductDetails(P.productName,P.unitPrice,P.avaible,B.brandName,C.categoryName) "
			+ " FROM Product P LEFT JOIN P.brand B LEFT JOIN P.category C WHERE P.productId= :productId ";

	public static final String findProductNames = "SELECT P.productName FROM Product P";

	public static final String findProductNamesPrice = "SELECT P.productName,P.unitPrice FROM Product P";

	public static final String findProductGreatPrice = "SELECT P FROM Product P WHERE P.unitPrice>:unitPrice ";

	public static final String findGreatLessPrice = "SELECT P FROM Product P WHERE P.unitPrice> :minUnitprice AND P.unitPrice< :maxUnitPrice ";

	public static final String findBetweenPrice = "SELECT P FROM Product P WHERE P.unitPrice BETWEEN :minUnitPrice AND :maxUnitPrice ";

	public static final String findLikeProductName = "SELECT P FROM Product P WHERE P.productName LIKE :productName ";

	// categoryýsý býlgýsayar ve tablet olanlarý getýr dedýk
	public static final String findInCategoryName = "SELECT P FROM Product P LEFT JOIN P.category C WHERE C.categoryName IN(:categoryName1 ,:categoryName2) ";

	// MARKASI ASUS VE TOSHIBA OLANLARI GETIR DEDIK
	public static final String findInBrandName = "SELECT P FROM Product P LEFT JOIN P.brand B WHERE B.brandName IN(:brandName1,:brandName2) ";

	// ALL DEDIGIMIZDE SUBQUERI YAPTIK.YANI unitPrice SU CATEGORIDI IDSINDEN
	// HEPSINDEN BUYUK OLANLARI GETIR DEDIK
	public static final String findAllProduct = "SELECT P FROM Product P WHERE P.unitPrice > "
			+ "ALL(SELECT P2.unitPrice FROM Product P2 WHERE P2.category.categoryId = :categoryId)";

	public static final String findFunctionsPrice = "SELECT AVG(P.unitPrice),SUM(P.unitPrice),MIN(P.unitPrice),MAX(P.unitPrice),COUNT(P.unitPrice) FROM Product P";

	public static final String findGroupByCategory = "Select P.category.categoryName,AVG(P.unitPrice) FROM Product P"
			+ " GROUP BY P.category.categoryName ";

	public static final String findGroupByHavingCategory = "SELECT P.category.categoryName,AVG(P.unitPrice) FROM Product P "
			+ "GROUP BY P.category.categoryName HAVING AVG(P.unitPrice)>:unitPrice";

	public static final String findGroupByBrand = "Select P.Brand.brandName,AVG(P.unitPrice) FROM Product P"
			+ " GROUP BY P.brand.brandName ";

	public static final String findGroupByHavingBrand = "SELECT P.Brand.brandName,AVG(P.unitPrice) FROM Product P"
			+ " GROUP BY P.brand.brandName HAVING AVG(P.unitPrice)>:unitPrice";

	// URUNLERIN FIYATLARINI BUYUKTEN KUCUGE GORE SIRALA DEDIK
	public static final String findOrderByDescPrice = "SELECT P FROM Product P ORDER BY P.unitPrice DESC";

	public static final String findOrderByAscPrice = "SELECT P FROM Product P ORDER BY P.unitPrice ASC";
}
