package com.wego.web.person;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.*;
import java.util.function.*;
import static java.util.Comparator.*;
import static java.util.stream.Collector.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wego.web.util.Printer;

@Service
public class PersonService {
	@Autowired private PersonRepository personRepository;
	@Autowired private Printer printer;
	
	public void findByHak() {
		//1. 단순 그룹화(반별로 그룹화)
		Map<Integer, List<Person>> map = personRepository
				.findGroupByHak().stream()
				.collect(Collectors.groupingBy(Person::getBan));
		for(List<Person> ban: map.values()) {
			for(Person p : ban) {
				printer.accept(p.toString());
			}
		}
	}
	public void groupByGrade() {
		//2. 단순그룹화(성적별로 그룹화)
		Map<Person.Level, List<Person>> map = personRepository
				.findGroupByHak().stream()
				.collect(Collectors.groupingBy(
						s->{
							if(s.getScore()>= 80) return Person.Level.HIGH;
							else if(s.getScore()>=50)return Person.Level.MID;
							else return Person.Level.LOW;}
						));
		TreeSet<Person.Level> keySet = new TreeSet<>(map.keySet());
		for(Person.Level key: keySet) {
			printer.accept("["+key+"]");
			for(Person p: map.get(key)) {
				printer.accept(p.toString());
			}
			System.out.println();
		}
		
	}
	public Object personCountByLevel() {
		//3. 단순그룹화(통계(성적별 학생수))
		return
				personRepository.findGroupByHak().stream()
				.collect(Collectors.groupingBy(s->{
					if(s.getScore()>= 80) return Person.Level.HIGH;
					else if(s.getScore()>=50)return Person.Level.MID;
					else return Person.Level.LOW;}, Collectors.counting()
				));
				
				
	}
	public Object multiGrouping() {
		// 4. 다중 그룹화 (학년별, 반별)
		return
				personRepository.findGroupByHak().stream()
				.collect(
					Collectors.groupingBy(Person::getHak, 
							Collectors.groupingBy(Person::getBan)
				));
	}
	public Object multiGroupingMax() {
		// 5. 다중 그룹화 +통계 (학년별, 반별 1등)
		return personRepository.findGroupByHak().stream()
				.collect(Collectors.groupingBy(Person::getHak,
						Collectors.groupingBy(Person::getBan,
								Collectors.collectingAndThen(
								Collectors.maxBy(Comparator
										.comparingInt(Person::getScore)),
								Optional::get))));
	}

}













