package generalTests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(GoodTestsCategory.class)
@ExcludeCategory(BadTestsCategory.class)
@Suite.SuiteClasses({
	GeneralTests.class,
	TrackingServiceTests.class
	})
public class GoodTestsSuite
{

}
