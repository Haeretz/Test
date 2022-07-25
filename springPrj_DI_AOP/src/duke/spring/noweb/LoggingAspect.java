package duke.spring.noweb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
	private Log log = LogFactory.getLog(getClass());

	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("기록 시작");
		StopWatch stopWatch = new StopWatch();
		try {
			stopWatch.start();
			Object retValue = joinPoint.proceed();
			return retValue;
		} catch (Throwable e) {
			throw e;
		} finally {
			stopWatch.stop();
			System.out.println("기록 종료");
					System.out.println(joinPoint.getSignature().getName() + "메소드 실행 시간 : "
					+ stopWatch.getTotalTimeMillis());
		}
	}
}