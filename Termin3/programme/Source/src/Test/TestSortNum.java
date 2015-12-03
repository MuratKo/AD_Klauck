package Test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import Helper.SortNum;
import Helper.SortNum.Parameter;

public class TestSortNum {

	String path;
	String fileNameWithDuplicates, fileNameWithoutDuplicates, fileNameBestCase, filenameWorseCase;
	File fileWithDuplicate, fileWithoutDuplicate, fileBestCase, fileWorseCase;
	@Before
	public void setUp() throws Exception {
		path = "C:/Users/abp516.INFORMATIK.000/Documents/AD_Klauck/Termin3/programme/zahlen/";
		
		fileNameWithDuplicates = "testRandomWithDuplicates.dat";
		fileWithDuplicate = SortNum.sortNum(10000, path + fileNameWithDuplicates, Parameter.RANDOM_WITH_DUPLICATES);
		
		fileNameWithoutDuplicates = "testRandomWithoutDuplicates.dat";
		fileWithoutDuplicate = SortNum.sortNum(10000, path + fileNameWithoutDuplicates, Parameter.RANDOM_WITHOUT_DUPLICATES);
	
		fileNameBestCase = "testBestCase.dat";
		fileBestCase = SortNum.sortNum(10000, path + fileNameBestCase, Parameter.BEST_CASE);
		
		filenameWorseCase = "testWorseCase.dat";
		fileWorseCase = SortNum.sortNum(10000, path + filenameWorseCase, Parameter.WORSE_CASE);
	
	
	
	}

	@Test
	public void test() {
		assertTrue(fileWithDuplicate.exists());
	}

}
