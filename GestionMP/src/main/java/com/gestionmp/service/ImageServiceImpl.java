package com.gestionmp.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gestionmp.entities.Image;
import com.gestionmp.entities.Patient;
import com.gestionmp.repos.ImageRepository;
import com.gestionmp.repos.PatientRepository;

@Service
public class ImageServiceImpl implements ImageService{
 @Autowired
 ImageRepository imageRepository;
 @Autowired
 PatientRepository patientRepository;
 @Autowired
 PatientService patientservice;
 @Override
 public Image uplaodImage(MultipartFile file) throws IOException {
 return imageRepository.save(Image.builder()
 .name(file.getOriginalFilename())
 .type(file.getContentType())
 .image(file.getBytes()).build() );
 }
 @Override
 public Image getImageDetails(Long id) throws IOException{
 final Optional<Image> dbImage = imageRepository. findById (id);
 return Image.builder()
 .idImage(dbImage.get().getIdImage())
 .name(dbImage.get().getName())
 .type(dbImage.get().getType())
 .image(dbImage.get().getImage()).build() ;
 }
 @Override
 public ResponseEntity<byte[]> getImage(Long id) throws IOException{
 final Optional<Image> dbImage = imageRepository. findById (id);
 return ResponseEntity
 .ok()
 .contentType(MediaType.valueOf(dbImage.get().getType()))
 .body(dbImage.get().getImage());
 }
 @Override
 public void deleteImage(Long id) {
 imageRepository.deleteById(id);
 }
 @Override
 public Image uplaodImagePat(MultipartFile file,Long idPat)
 throws IOException {
 Patient p = new Patient();
 p.setIdPatient(idPat);
 return imageRepository.save(Image.builder()
  .name(file.getOriginalFilename())
  .type(file.getContentType())
  .image(file.getBytes())
  .patient(p).build() );
 }
 @Override
 public List<Image> getImagesParPat(Long patId) {
 Patient p = patientRepository.findById(patId).get();
 return p.getImages();
 } 
}

