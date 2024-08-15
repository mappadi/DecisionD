package framework.platform.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.testng.Assert.fail;

/**
 * DataBaseUtils
 */
public class DataBaseUtils {

	public DataBaseUtils() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't find SQL driver", e);
		}
	}

	public Connection openConnection() {
		try {
			return DriverManager.getConnection("jdbc:sqlserver://PrimaryDB\\sqldist:1433", "agorauser", "page0491");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Couldn't connect to DB", e);
		}
	}

	public String getValues() {
		String state = null;
		try (Connection con = openConnection();
			 PreparedStatement ps = con.prepareStatement("USE CMS\n" +
					 "SELECT  p.ProductID, p.MaskUrl, a.Headline, a.Deck, at.ArticleType, a.LastUpdated, p.IsActive\n" +
					 ",media.MediaID, media.MediaTagName, media.MediaTypeName, media.MediaAttributeName, media.MediaAttributeValue\n" +
					 "     FROM dbo.cmsPage p\n" +
					 "     LEFT JOIN cmsBackend.cmsArticle a ON p.PageID = a.PageID\n" +
					 "     LEFT JOIN cmsBackend.cmsArticleType at ON at.ArticleTypeID = a.ArticleTypeID   \n" +
					 "     LEFT JOIN (\n" +
					 "              SELECT a.ArticleID,am.MediaID, am.MediaTagName, mt.MediaTypeName, ma.MediaAttributeName, ma.MediaAttributeValue\n" +
					 "              FROM cmsBackend.cmsArticle a\n" +
					 "              JOIN cmsBackend.cmsArticleMedia am ON a.ArticleID = am.ArticleID\n" +
					 "              JOIN cmsBackend.cmsMedia m ON am.MediaID = m.MediaID\n" +
					 "              JOIN cmsBackend.cmsMediaType mt ON mt.MediaTypeID = m.MediaTypeID\n" +
					 "              JOIN cmsBackend.cmsMediaAttribute ma ON ma.MediaID = m.MediaID\n" +
					 "              WHERE\n" +
					 "              --a.PageID = 306799 AND\n" +
					 "              ma.MediaAttributeValue IS NOT NULL AND ma.IsActive = 1 AND (a.SortOrder IS NULL OR a.SortOrder = 0)\n" +
					 "     )media ON\n" +
					 "     media.ArticleID = a.ArticleID\n" +
					 "     WHERE\n" +
					 "     p.MaskURL != ''\n" +
					 "     AND p.ProductID IN (277,256)\n" +
					 "     AND\n" +
					 "     (a.SortOrder IS NULL OR a.SortOrder = 0)\n" +
					 "     AND p.IsActive = 1")) {
			try (ResultSet rs = ps.executeQuery()) {
				//while(rs.next())
				for(int i =0; i<1000;i++){
					if(rs.next()){
					System.out.println("ProductID: "+rs.getString("ProductID"));
					System.out.println("MaskUrl: "+rs.getString("MaskUrl"));
					System.out.println("Headline: "+rs.getString("Headline"));
					System.out.println("Deck: "+rs.getString("Deck"));
					System.out.println("ArticleType: "+rs.getString("ArticleType"));
					System.out.println("LastUpdated: "+rs.getString("LastUpdated"));
					System.out.println("IsActive: "+rs.getString("IsActive"));
					System.out.println("MediaID: "+rs.getString("MediaID"));
					System.out.println("MediaTagName: "+rs.getString("MediaTagName"));
					System.out.println("MediaTypeName: "+rs.getString("MediaTypeName"));
					System.out.println("MediaAttributeName: "+rs.getString("MediaAttributeName"));
					System.out.println("MediaAttributeValue: "+rs.getString("MediaAttributeValue"));
					System.out.println("------------------------------------------");
			}}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			fail("An SQLException occurred when attempting to get status");
		}
		return state;
	}
}
