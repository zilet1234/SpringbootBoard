package com.general.model.dao.login.service;

import com.general.model.dao.login.domain.Member;
import com.general.model.dao.login.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 곽우영
 * @since 2019-03-25
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Override
	public Member get(Integer memberSeq) {
		return memberRepository.findOne(memberSeq);
	}

	@Override
	public List<Member> getAll() {
		return memberRepository.findAll();
	}

	@Override
	public Member set(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public List<Member> sets(List<Member> members) {
		return memberRepository.save(members);
	}

	@Override
	public void remove(Integer memberSeq) {
		memberRepository.delete(memberSeq);
	}

	@Override
	public void removes(List<Integer> memberSeqs) {
		for (Integer memberSeq : memberSeqs) {
			remove(memberSeq);
		}
	}

	@Override
	public Member modify(Member member) {
		return memberRepository.save(member);
	}
}
