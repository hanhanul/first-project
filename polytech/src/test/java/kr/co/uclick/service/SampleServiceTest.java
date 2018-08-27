package kr.co.uclick.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import com.google.common.base.Stopwatch;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.Member;
import kr.co.uclick.entity.Sample;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SampleServiceTest {
	
	@Autowired
	SampleService sampleService;
	
//	@Test
//	public void testSelectOne() {
//		StopWatch sw = new StopWatch();
//		sw.start();
//		Sample s1 = sampleService.selectOne(1L);
//		sw.stop();
//		
//		System.out.println("total time : " + sw.getTotalTimeSeconds());
//		
//		sw = new StopWatch();
//		sw.start();
//		Sample s2 = sampleService.selectOne(1L);
//		sw.stop();
//		
//		System.out.println("total time : " + sw.getTotalTimeSeconds());
//		
//		assertEquals(1, s1.getId().intValue());
//	}
	
	@Test
	public void testUpdateOne() {
		StopWatch sw = new StopWatch();
		sw.start();
		Sample s1 = sampleService.selectOne(1L);
		sw.stop();
		System.out.println("1 total time : " + sw.getTotalTimeSeconds());
		
		sw = new StopWatch();
		sw.start();
		Sample s2 = sampleService.selectOne(1L);
		sw.stop();
		System.out.println("2 total time : " + sw.getTotalTimeSeconds());
		
		sw = new StopWatch();
		sw.start();
		Sample s3 = sampleService.selectOne(1L);
		sw.stop();
		System.out.println("3 total time : " + sw.getTotalTimeSeconds());
		
		assertEquals(1, s1.getId().intValue());
		
		s1.setNumber(555);
		sampleService.updateOne(s1);
		
		sw = new StopWatch();
		sw.start();
		Sample s4 = sampleService.selectOne(1L);
		sw.stop();
		System.out.println("4 total time : " + sw.getTotalTimeSeconds());
		
		sw = new StopWatch();
		sw.start();
		Sample s5 = sampleService.selectOne(1L);
		sw.stop();
		System.out.println("5 total time : " + sw.getTotalTimeSeconds());
		
		sw = new StopWatch();
		sw.start();
		Sample s6 = sampleService.selectOne(1L);
		sw.stop();
		System.out.println("6 total time : " + sw.getTotalTimeSeconds());
	}
}
