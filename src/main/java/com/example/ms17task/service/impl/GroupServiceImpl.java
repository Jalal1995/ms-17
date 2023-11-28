//package com.example.ms17task.service.impl;
//
//import com.example.ms17task.dto.GroupDto;
//import com.example.ms17task.repository.GroupRepository;
//import com.example.ms17task.service.GroupService;
//import java.util.List;
//import java.util.stream.Collectors;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//@RequiredArgsConstructor
//public class GroupServiceImpl implements GroupService {
//
//
//    private final GroupRepository groupRepository;
//
//
//    private final ModelMapper modelMapper;
//
//
//    @Override
//    @Transactional
//    public List<GroupDto> findAll() {
//
//        return groupRepository
//                .findAll()
//                .stream()
//                .map(group -> modelMapper.map(group, GroupDto.class))
//                .collect(Collectors.toList());
//
//    }
//}
