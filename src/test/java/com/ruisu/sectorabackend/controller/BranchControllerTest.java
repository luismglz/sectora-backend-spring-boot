package com.ruisu.sectorabackend.controller;

import com.ruisu.sectorabackend.entity.Branch;
import com.ruisu.sectorabackend.service.BranchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BranchController.class)
class BranchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Branch branch;

    @MockBean
    private BranchService branchService;

    @BeforeEach
    void setUp() {
        branch = Branch.builder()
                .id(1L)
                .name("Asakusa")
                .address("2-10 Asakusa Taito-ku Tokyo, JAPAN, 111-0032")
                .telephone("0570-055-801")
                .build();
    }

    @Test
    public void saveBranch() throws Exception{
        Branch postedBranch = Branch.builder()
                .name("Asakusa")
                .address("2-10 Asakusa Taito-ku Tokyo, JAPAN, 111-0032")
                .telephone("0570-055-801")
                .build();

        Mockito.when(branchService.saveBranch(postedBranch)).thenReturn(branch);
        mockMvc.perform(post("/api/v1/branches").contentType(MediaType.APPLICATION_JSON)
                .content("{\n"+
                        "   \"name\":\"Asakusa\",\n"+
                        "   \"address\":\"2-10 Asakusa Taito-ku Tokyo, JAPAN, 111-0032\",\n"+
                        "   \"telephone\":\"0570-055-801\"\n"+
                        "}"
                        ))
                .andExpect(status().isOk());

    }

    @Test
    public void findBranchById() throws Exception{
        Mockito.when(branchService.findById(1L)).thenReturn(branch);

        mockMvc.perform(get("/api/v1/branches/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(branch.getName()));

    }
}