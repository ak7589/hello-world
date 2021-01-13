package com.edulab.subscription.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edulab.subscription.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Override
	public boolean isValidMember(Member member) {
		// TODO Auto-generated method stub
		boolean retval = false;
				
		logger.info("Extracted Member ID2222 : " + member.getMemberId());
		
		if(member.getMemberId() != null && ! member.getMemberId().trim().isEmpty())
		{
			retval = true;
		}
		
		return retval;
	}

	

}
