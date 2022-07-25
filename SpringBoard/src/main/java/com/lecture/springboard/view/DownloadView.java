package com.lecture.springboard.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component("download")
public class DownloadView extends AbstractView {
	private static final Logger logger = LoggerFactory.getLogger(DownloadView.class);

	private String convertEncoding(HttpServletRequest request, String name) throws UnsupportedEncodingException {
		if (request.getHeader("User-Agent").indexOf("MSIE") > -1
				|| request.getHeader("User-Agent").indexOf("Gecko") > -1) {
			return URLEncoder.encode(name, "utf-8");
		} else {
			return new String(name.getBytes("utf-8"), "iso-8859-1");
		}
	}

	private void write(HttpServletResponse response, File file) {
		FileInputStream in = null;
		try {
			OutputStream out = response.getOutputStream();
			in = new FileInputStream(file);
			FileCopyUtils.copy(in, out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("download 뷰실행");

		String mode = (String) model.get("mode");
		File file = (File) model.get("downloadFile");
		String name = convertEncoding(request, (String) model.get("name"));
		response.setContentLength((int) file.length());

		if (mode.equals("get")) {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + name + "\"");
		} else {
			MimetypesFileTypeMap mfm = new MimetypesFileTypeMap();
			response.setContentType(mfm.getContentType(file));
			response.setHeader("Content-Disposition", "filename=" + name);
		}

		this.write(response, file);
	}

}
