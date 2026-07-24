import React from 'react';
import { describe, test, expect } from 'vitest';
import { mount, shallow } from 'enzyme';
import { CohortDetails, CohortData } from './App';

describe('Cohort Details Component', () => {
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]}/>);
    expect(wrapper.exists()).toBe(true);
  });

  test('should initialize the props', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]}/>);
    expect(wrapper.props().cohort).toEqual(CohortData[0]);
  });

  test('should display cohort code in h3', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]}/>);
    expect(wrapper.find('h3').text()).toBe(CohortData[0].code);
  });

  test('should always render same html', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]}/>);
    expect(wrapper.html()).toMatchSnapshot();
  });
});
